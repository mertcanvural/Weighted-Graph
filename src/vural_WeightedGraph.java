import java.util.ArrayList;

import javax.lang.model.type.NoType;

public class vural_WeightedGraph implements WeightedGraphFunctions {
    private final java.util.ArrayList<Integer> vertices; // contains the vertices
    private final java.util.ArrayList<WeightedEdge> edges; // contains the list of edges
    private boolean debugOutput; //

    vural_WeightedGraph() {
        this.vertices = new ArrayList<Integer>();
        this.edges = new ArrayList<WeightedEdge>();
        this.debugOutput = false;
    }

    /**
     * @param v
     * @return the index of the vertex v in the vertices ArrayList
     */
    public int getIndex(Integer v) {
        for (int i = 0; i < vertices.size(); i++) {
            if (v == vertices.get(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns whether there is a path from the fromVertex to the toVertex in
     * our WeightedGraph.
     * 
     * Returns false if no such path exists.
     * 
     * @param int fromVertex - specifies the source vertex we are starting from
     * @param int toVertex - specifies the destination vertex we are trying to reach
     * 
     * @return whether the WeightedGraph has a path between the specified vertices
     */
    public boolean hasPath(int fromVertex, int toVertex) {
        Object returnedObject = getPath(fromVertex, toVertex, WeightedGraphReturnType.HAS_PATH);
        if (returnedObject == null) {
            return false;
        }
        return (boolean) returnedObject;
    }

    /**
     * Computes and returns the cost of a minimum cost path from the fromVertex to
     * the toVertex
     * in our WeightedGraph.
     * 
     * Returns Double.NaN if no such path exists.
     * 
     * @param int fromVertex - specifies the source vertex we are starting from
     * @param int toVertex - specifies the destination vertex we are trying to reach
     * 
     * @return the cost of a minimum cost path between the specified verticies
     */
    public double getMinimumWeight(int fromVertex, int toVertex) {
        Object returnedObject = getPath(fromVertex, toVertex, WeightedGraphReturnType.GET_MINIMUM_WEIGHT);
        if (returnedObject == null) {
            return Double.NaN;
        }
        double aDouble = (double) returnedObject;
        return aDouble;
    }

    /**
     * Returns a minimum cost path from the fromVertex to the toVertex, as an array.
     * 
     * Returns an array of length zero if no such path exists.
     * 
     * @param int fromVertex - specifies the source vertex we are starting from
     * @param int toVertex - specifies the destination vertex we are trying to reach
     * 
     * @return a minimum cost path specifying how we would minimally travel between
     *         the specified vertices
     */
    public WeightedEdge[] getPath(int fromVertex, int toVertex) {
        Object returnedObject = getPath(fromVertex, toVertex, WeightedGraphReturnType.GET_PATH);
        if (returnedObject == null) {
            return new WeightedEdge[0];
        } else {
            return (WeightedEdge[]) returnedObject;
        }

    }

    /**
     * Delegate method that does all of the work. Should be called by:
     * 
     * 1. hasPath() - specify HAS_PATH
     * 2. getMinimumWeight() - specify GET_MINIMUM_WEIGHT
     * 3. getPath() - specify GET_PATH
     * 
     * with the WeightedGraphReturnType set to the appropriate value for each.
     * 
     * Upon receiving the Object returned, each method should downcast to their
     * expected return type.
     * 
     * @param int                     fromVertex - specifies the from vertex
     * @param int                     toVertex - specifies the to vertex
     * @param WeightedGraphReturnType typeOfInfo - disambiguates what type of info
     *                                we are trying to work out and return
     * 
     * @return a general Object is returned which can be a:
     *         1. boolean (hasPath)
     *         2. double (getMinimumWeight)
     *         3. WeightedEdge[] (getPath)
     * 
     *         Depending on what is trying to be determined.
     */
    private Object getPath(int fromVertex, int toVertex, WeightedGraphReturnType typeOfInfo) {
        // minimum priority queue
        java.util.PriorityQueue<WeightedVertex> minPriorityQueueByWeight = new java.util.PriorityQueue<>(
                vertices.size(), new WeightedVertexComparator());
        // get minimum cost/weight to reach a vertice
        WeightedVertex[] verticeCost = new WeightedVertex[vertices.size()];
        // will used for backtracking to the source vertex
        int[] parent = new int[vertices.size()];
        // populate
        for (int i = 0; i < vertices.size(); i++) {
            parent[i] = -1;
            verticeCost[i] = new WeightedVertex(vertices.get(i).intValue(), Double.POSITIVE_INFINITY);
        }
        // starting vertex
        int fromVertexIndex = getIndex(fromVertex);
        parent[fromVertexIndex] = fromVertex;
        verticeCost[fromVertexIndex] = new WeightedVertex((vertices.get(fromVertexIndex)).intValue(), 0.0);

        // Add all of the elements of verticeCost to minPriorityQueueByWeight
        for (int i = 0; i < vertices.size(); i++) {
            minPriorityQueueByWeight.add(verticeCost[i]);
        }

        while (minPriorityQueueByWeight.size() > 0) {
            WeightedVertex v = minPriorityQueueByWeight.poll();
            int indexOfV = getIndex(v.getVertex());
            // not reachable
            if (parent[indexOfV] == -1) {
                break;
            }
            // v == destination vertex
            if ((v.getVertex()) == (Integer.valueOf(toVertex))) {
                break;
            }

            for (WeightedEdge edge : edges) {
                // current edge's from vertex == v
                if (edge.getFromVertex() == v.getVertex()) {
                    // -> set u as the to vertex
                    int indexOfToVertex = getIndex(Integer.valueOf(edge.getToVertex()));
                    WeightedVertex u = verticeCost[indexOfToVertex];
                    // 0 + 1 < ∞
                    if ((v.getWeight() + edge.getWeight()) < u.getWeight()) {
                        // Update the cost to get to u
                        int uIndex = getIndex(u.getVertex());
                        verticeCost[uIndex].setWeight(v.getWeight() + edge.getWeight());
                        // Remove the WeightedVertex for u from minPriorityQueueByWeight
                        minPriorityQueueByWeight.remove(u);
                        // Update the weight/cost for u to cost of v + edge weight of the current edge
                        u.setWeight(v.getWeight() + edge.getWeight());
                        // Add the updated WeightedVertex for u back into minPriorityQueueByWeight
                        minPriorityQueueByWeight.add(u);
                        // Update the parent of u to be v
                        parent[uIndex] = v.getVertex();
                    }
                }
            }
        }
        // 7. Check to see if there is a path to the destination vertex
        int destinationIndex = getIndex(Integer.valueOf(toVertex));
        int sourceIndex = getIndex(Integer.valueOf(fromVertex));
        //System.out.println("here1");
        if (parent[destinationIndex] != -1) {
            //System.out.println("here2");
            if (typeOfInfo == WeightedGraphReturnType.HAS_PATH) {
                //System.out.println("here3");
                boolean pathExist = true;
                return pathExist;
            } else if (typeOfInfo == WeightedGraphReturnType.GET_MINIMUM_WEIGHT) {
                //System.out.println("here4");
                Object minWeight = verticeCost[destinationIndex].getWeight();
                return minWeight;
            } else if (typeOfInfo == WeightedGraphReturnType.GET_PATH) {
                //System.out.println("here5");
                java.util.ArrayList<WeightedVertex> reversePath = new ArrayList<WeightedVertex>();
                java.util.ArrayList<WeightedVertex> forwardPath = new ArrayList<WeightedVertex>();
                // construct a path from the source vertex to the destination vertex
                WeightedVertex p = verticeCost[destinationIndex];
                reversePath.add(p);
                while (p != verticeCost[sourceIndex]) {
                    //System.out.println("here6");
                    int parentIndex = parent[getIndex(p.getVertex())];
                    p = verticeCost[parentIndex];
                    reversePath.add(p);
                }
                // create a forward path from the source vertex to the destination vertex:

                for (int i = reversePath.size() - 1; i >= 0; i--) {
                    forwardPath.add(reversePath.get(i));
                }
                WeightedEdge[] arrayOfEdges = new WeightedEdge[forwardPath.size() - 1];

                for (int i = 0; i < forwardPath.size() - 1; i++) {
                    for (WeightedEdge edge : edges) {
                        if ((edge.getFromVertex() == forwardPath.get(i).getVertex())
                                && (edge.getToVertex() == forwardPath.get(i + 1).getVertex())) {
                            arrayOfEdges[i] = edge;
                            break;
                        }
                    }
                }
                return arrayOfEdges;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * Adds a vertex to the weighted graph. Returns whether the addition was
     * successful or not.
     * If the vertex already exists, do not add it, and return false.
     * 
     * @param int v - specifies the vertex to be added
     * 
     * @return whether adding the vertex to our Weighted Graph was successful
     */
    public boolean addVertex(int v) {
        if (vertices.contains(v)) {
            return false;
        }
        vertices.add(v);
        return true;
    }

    /**
     * Adds a weighted edge to the Weighted Graph. Returns whether the addition was
     * successful or not.
     * If the weighted edge already exists, do not add it, and return false.
     * 
     * An edge is considered to already exist if we already have an edge in the
     * graph between the specified from and to vertices.
     * 
     * @param int    from - specifies the from vertex of the edge being added
     * @param int    to - specifies the to vertex of the edge being added
     * @param double weight - specifies the weight of the edge being added
     * 
     * @return whether adding the edge to our Weighted Graph was successful
     */
    public boolean addWeightedEdge(int from, int to, double weight) {
        for (WeightedEdge edge : edges) {
            if ((edge.getFromVertex() == from) && (edge.getToVertex() == to)) {
                return false;
            }
        }
        edges.add(new WeightedEdge(from, to, weight));
        return true;
    }

    /**
     * Returns a string representation of the Weighted Graph.
     * 
     * Example:
     * 
     * 1. G = (V, E)
     * 2. V = {1,2,3,4,5,6,7,8,9,10,11,12,13}
     * 3. E =
     * {(1,2,1.0),(1,3,3.0),(1,4,5.0),(2,3,1.0),(3,4,1.0),(1,5,1.0),(4,6,2.0),(5,6,1.0),(4,7,6.0),(6,7,5.0),(5,8,4.0),(6,9,2.0),(7,10,2.0),(8,11,8.0),(9,12,5.0),(9,13,2.0),(9,8,3.0),(10,13,5.0),(12,11,1.0),(13,12,3.0),(10,9,1.0)}
     * 
     * @return string representation of the Weighted Graph
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("G = (V, E)\n");
        sb.append("V = {");
        for (Integer vertex : vertices) {
            sb.append(vertex.toString() + ",");
        }
        // removing the last comma
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}\n");
        sb.append("E = {");
        for (WeightedEdge edge : edges) {
            sb.append(edge.toString() + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}