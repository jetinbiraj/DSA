# Graphs

**Graph definition: A graph is mathematically defined as a set of nodes (vertices) and a set of edges connecting them,
often written as G=(V,E) where V represents the set of vertices and E represents the set of edges.**

## Basic concepts

**Nodes/Vertices** :- A fundamental unit representing a single point or object within a graph, which connects to other
nodes via "edges" to show relationships between them; essentially, a node is a data point in a network structure
depicted by a graph.

Edge :- a line (or curve) connects any two vertices representing objects that are related or adjacent; such a line is
called an edge.

## Types of graphs

1. Undirected Graphs :- Edges are not directed between nodes, Simply edge can be in both the direction
2. Directed Graphs :- Nodes have directed edge


#### Dijkstra : from a single source, find shortest paths to all nodes.

#### Floyd-Warshall : shortest path from every node as a source.

#### Bellman-Ford : same as Dijkstra, but works for negative weights.

#### Topological Sort : print the nodes with no incoming edges first.

#### MST : connect all the nodes with minimum costs (n nodes // n-1 edges).

#### Prim's Algo : build the MST by starting from any node and expanding the tree one edge at a time.

#### Kruskal Algo : build the MST by sorting all edges and adding them one by one, ensuring no cycles are formed.