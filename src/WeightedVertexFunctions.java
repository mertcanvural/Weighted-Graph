interface WeightedVertexFunctions
{
    /**
     * Returns the weight (ie cost) of the Weighted Vertex
     * 
     * @return the weight of the Weighted Vertex
     */ 
    public double getWeight();

    /**
     * Returns the vertex value of the Weighted Vertex
     * 
     * @return the vertex value of the Weighted Vertex
     */ 
    public int getVertex();

    /**
     * Setter for the weight (ie cost) of the Weighted Vertex
     * 
     * @param double w - specifies the new weight
     */ 
    public void setWeight(double w);

    /**
     * Returns whether this Weighted Vertex is equal to some other specified object.
     * 
     * @param Object o - the other object being compared to for equality.
     * @return whether the other object is considered equal to this Weighted Vertex.
     */ 
    public boolean equals(Object o);

    /**
     * Returns a string representation of the Weighted Vertex.
     * 
     * Form is "(x,w)", where:
     * x - is the vertex value
     * w - is the vertex weight (ie cost).
     * 
     * @return string representation of the Weighted Vertex.
     */ 
    public String toString();
}