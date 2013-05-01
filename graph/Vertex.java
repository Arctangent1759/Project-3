package graph;
import DList.*;

/**
 *
 * Internal representation of vertices
 *
 **/

class Vertex{
  EdgeList edges;
  Object item;

  /**
   *
   * Constructors creates a new vertex with an object and an empty EdgeList
   *
   * @param item the object at this vertex
   *
   **/
  public Vertex(Object item){
    this.item = item;
    edges = new EdgeList();
  }
}
