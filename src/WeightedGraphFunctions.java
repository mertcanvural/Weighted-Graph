interface WeightedGraphFunctions {
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
    public boolean hasPath(int fromVertex, int toVertex);

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
    public double getMinimumWeight(int fromVertex, int toVertex);

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
    public WeightedEdge[] getPath(int fromVertex, int toVertex);

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
    public boolean addVertex(int v);

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
    public boolean addWeightedEdge(int from, int to, double weight);

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
    public String toString();
}
