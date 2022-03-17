public Vertex addVertex(String newVertexLabel) {
   // Create the new Vertex object
   Vertex newVertex = new Vertex(newVertexLabel);

   // Every vertex must exist as a key in both maps
   fromEdges.put(newVertex, new ArrayList<Edge>());
   toEdges.put(newVertex, new ArrayList<Edge>());

   return newVertex;
}

public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex, double weight) {
   // Don't add the same edge twice
   if (hasEdge(fromVertex, toVertex)) {
      return null;
   }

   // Create the Edge object
   Edge newEdge = new Edge(fromVertex, toVertex, weight);

   // Add the edge to the appropriate list in both maps
   fromEdges.get(fromVertex).add(newEdge);
   toEdges.get(toVertex).add(newEdge);

   return newEdge;
}

public Edge[] addUndirectedEdge(Vertex vertexA, Vertex vertexB, double weight) {
   Edge edge1 = addDirectedEdge(vertexA, vertexB, weight);
   Edge edge2 = addDirectedEdge(vertexB, vertexA, weight);
   Edge[] result = { edge1, edge2 };
   return result;
}

// Returns true if this graph has an edge from fromVertex to toVertex
public boolean hasEdge(Vertex fromVertex, Vertex toVertex) {
   if (!fromEdges.containsKey(fromVertex)) {
      // fromVertex is not in this graph
      return false;
   }

   // Search the list of edges for an edge that goes to toVertex
   ArrayList<Edge> edges = fromEdges.get(fromVertex);
   for (Edge edge : edges) {
      if (edge.toVertex == toVertex) {
         return true;
      }
   }

   return false;
}

class Graph {
   // Maps a vertex to an ArrayList of all edges that start from that vertex
   private HashMap<Vertex, ArrayList<Edge>> fromEdges;
   
   // Maps a vertex to an ArrayList of all edges that go to that vertex
   private HashMap<Vertex, ArrayList<Edge>> toEdges;
    
   public Graph() {
      fromEdges = new HashMap<Vertex, ArrayList<Edge>>();
      toEdges = new HashMap<Vertex, ArrayList<Edge>>();
   }

   // Returns a collection of all edges in the graph
   public Collection<Edge> getEdges() {
      HashSet<Edge> edges = new HashSet<Edge>();
      for (ArrayList<Edge> edgeList : fromEdges.values()) {
         edges.addAll(edgeList);
      }
      return edges;
   }

   // Returns the collection of edges with the specified fromVertex
   public Collection<Edge> getEdgesFrom(Vertex fromVertex) {
      return fromEdges.get(fromVertex);
   }

   // Returns the collection of edges with the specified toVertex
   public Collection<Edge> getEdgesTo(Vertex toVertex) {
      return toEdges.get(toVertex);
   }

   // Returns a vertex with a matching label, or null if no such vertex exists
   public Vertex getVertex(String vertexLabel) {
      // Search the collection of vertices for a vertex with a matching label
      for (Vertex vertex : getVertices()) {
         if (vertex.label.equals(vertexLabel)) {
            return vertex;
         }
      }
      return null;
   }

   // Returns the collection of all of this graph's vertices
   public Collection<Vertex> getVertices() {
      return fromEdges.keySet();
   }

   ...
}

public Vertex addVertex(String newVertexLabel) {
   // Create the new Vertex object
   Vertex newVertex = new Vertex(newVertexLabel);

   // Every vertex must exist as a key in both maps
   fromEdges.put(newVertex, new ArrayList<Edge>());
   toEdges.put(newVertex, new ArrayList<Edge>());
  
   return newVertex;
}
   
public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex, double weight) {
   // Don't add the same edge twice
   if (hasEdge(fromVertex, toVertex)) {
      return null;
   }
      
   // Create the Edge object
   Edge newEdge = new Edge(fromVertex, toVertex, weight);
      
   // Add the edge to the appropriate list in both maps
   fromEdges.get(fromVertex).add(newEdge);
   toEdges.get(toVertex).add(newEdge);
      
   return newEdge;
}
   
public Edge[] addUndirectedEdge(Vertex vertexA, Vertex vertexB, double weight) {
   Edge edge1 = addDirectedEdge(vertexA, vertexB, weight);
   Edge edge2 = addDirectedEdge(vertexB, vertexA, weight);
   Edge[] result = { edge1, edge2 };
   return result;
}

// Returns true if this graph has an edge from fromVertex to toVertex
public boolean hasEdge(Vertex fromVertex, Vertex toVertex) {
   if (!fromEdges.containsKey(fromVertex)) {
      // fromVertex is not in this graph
      return false;
   }
      
   // Search the list of edges for an edge that goes to toVertex
   ArrayList<Edge> edges = fromEdges.get(fromVertex);
   for (Edge edge : edges) {
      if (edge.toVertex == toVertex) {
         return true;
      }
   }
   
   return false;
}

// removal

AVLTreeRemoveNode(tree, node) {
   if (node == null) {
      return false
   }

   // Parent needed for rebalancing
   parent = node⇢parent
        
   // Case 1: Internal node with 2 children
   if (node⇢left != null && node⇢right != null) {
      // Find successor
      succNode = node⇢right
      while (succNode⇢left != null) {
         succNode = succNode⇢left
      }

      // Copy the key from the successor node
      node⇢key = succNode⇢key
            
      // Recursively remove successor
      AVLTreeRemoveNode(tree, succNode)
            
      // Nothing left to do since the recursive call will have rebalanced
      return true
   }

   // Case 2: Root node (with 1 or 0 children)
   else if (node == tree⇢root) {
      if (node⇢left != null) {
         tree⇢root = node⇢left
      }
      else {
         tree⇢root = node⇢right
      }
      if (tree⇢root) {
         tree⇢root⇢parent = null
      }
      return true
   }

   // Case 3: Internal with left child only
   else if (node⇢left != null) {
      AVLTreeReplaceChild(parent, node, node⇢left)
   }
   // Case 4: Internal with right child only OR leaf
   else {
      AVLTreeReplaceChild(parent, node, node⇢right)
   }

   // node is gone. Anything that was below node that has persisted is already correctly
   // balanced, but ancestors of node may need rebalancing.
   node = parent
   while (node != null) {
      AVLTreeRebalance(tree, node)            
      node = node⇢parent
   }
   return true
}