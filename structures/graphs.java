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
