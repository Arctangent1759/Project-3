package graph;
import DList.*;
import GraphStruct.*;

public class Vertex{
  EdgeList edges;
  Object item;
  public Vertex(Object item){
    this.item = item;
    edges = new EdgeList();
  }
}
