class WeightedVertexComparator implements java.util.Comparator<WeightedVertex>
{

    /**
     * Defines how WeightedVertex objects are to be compared to one another.
     * High level, we try to order WeightedVertex objects primarily by their weight (ie costs).
     * 
     * WeightedVertex objects with lower weights indicate more promising paths to consider when
     * attempting to build up our minimum cost path from the source vertex 
     * to some destination vertex.
     */ 
    public int compare(WeightedVertex o1, WeightedVertex o2)
    {
        if( o1.getWeight() < o2.getWeight() )
        {
            return -1;
        }
        
        if( o1.getWeight() > o2.getWeight() )
        {
            return 1;
        }
        
        if( o1.getVertex() < o2.getVertex() )
        {
            return -1;
        }
        
        if( o1.getVertex() > o2.getVertex() )
        {
            return 1;
        }
        
        return 0;
    }
}
