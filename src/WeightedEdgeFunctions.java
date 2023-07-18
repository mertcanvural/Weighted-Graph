interface WeightedEdgeFunctions
{
    /**
     * Returns the from vertex of the Weighted Edge
     * 
     * @return the from vertex
     */ 
    public int getFromVertex();

    /**
     * Returns the to vertex of the Weighted Edge
     * 
     * @return the to vertex
     */ 
    public int getToVertex();

    /**
     * Returns the weight of the Weighted Edge
     * 
     * @return the weight
     */ 
    public double getWeight();

    /**
     * Returns a string representation of the Weighted Edge.
     * 
     * Form is "(x,y,w)", where:
     * x - is the from vertex
     * y - is the to vertex
     * w - is the weight
     * 
     * @return string representation of this Weighted Edge.
     */ 
    public String toString();
}
