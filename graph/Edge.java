package graph;
import DList.*;

public class Edge{
    public Vertex v1;
    public Vertex v2;
    int weight;
    Edge partner; 
    DListNode<Edge> container;
 
   /**
    * Edge constructor
    *
    * @param v1 the first vertex incident to the edge  
    * @param v2 the second vertex incident to the edge
    * @param container the node containing this edge
   **/
    public Edge(Vertex v1, Vertex v2, int weight, DListNode<Edge> container){
      this.v1 = v1;
      this.v2 = v2;
      this.container = container;
      this.weight = weight;
      this.partner = null;
    }

    public void setPartner(Edge partner){
      this.partner = partner;
    }

    public Edge getPartner(){
      return partner;
    }

    public VertexPair vertices(){
      return new VertexPair(v1,v2);
    }
}
