package graph;
import DList.DList;
public class Vertex{
  DList<Edge> chain;
  Object item;
  public Vertex(Object item){
    this.item=item;
    chain=new DList<Edge>();
  }
  public void insert(Vertex e, double weight){
    chain.push(new Edge(e,weight));
  }
}
class Edge{
  double weight;
  Vertex target;
  public Edge(Vertex v, double w){
    this.target=v;
    this.weight=w;
  }
  public Edge(Vertex v){
    this(v,0);
  }
}
