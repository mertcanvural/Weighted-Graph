class WeightedVertex implements WeightedVertexFunctions {

    private final Integer vertex;
    private Double weight;

    /**
     * Value constructor for a WeightedVertex
     * 
     * @param int    v - specifies the vertex value
     * @param double w - specifies the weight (ie cost)
     */
    WeightedVertex(int v, double w) {
        this.vertex = Integer.valueOf(v);
        this.weight = Double.valueOf(w);
    }

    /**
     * Returns the weight (ie cost) of the Weighted Vertex
     * 
     * @return the weight of the Weighted Vertex
     */
    public double getWeight() {
        return this.weight.doubleValue();
    }

    /**
     * Returns the vertex value of the Weighted Vertex
     * 
     * @return the vertex value of the Weighted Vertex
     */
    public int getVertex() {
        return this.vertex.intValue();
    }

    /**
     * Setter for the weight (ie cost) of the Weighted Vertex
     * 
     * @param double w - specifies the new weight
     */
    public void setWeight(double w) {
        this.weight = Double.valueOf(w);
    }

    /**
     * Returns whether this Weighted Vertex is equal to some other specified object.
     * 
     * @param Object o - the other object being compared to for equality.
     * @return whether the other object is considered equal to this Weighted Vertex.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof WeightedVertex) {
            if (this.getVertex() == ((WeightedVertex) o).getVertex()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of the Weighted Vertex.
     * 
     * Form is "(x,w)", where:
     * x - is the vertex value
     * w - is the vertex weight (ie cost).
     * 
     * @return string representation of the Weighted Vertex.
     */
    public String toString() {
        return "(" + this.getVertex() + "," + this.getWeight() + ")";
    }
}
