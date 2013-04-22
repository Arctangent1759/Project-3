package graph;
import DList.*;

public class Vertex{
  EdgeList edges;
  Object item;
  public Vertex(Object item){
    this.item = item;
    edges = new EdgeList();
  }
}
