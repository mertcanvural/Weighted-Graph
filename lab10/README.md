------------------------------------
Lab 10 - Due 11/8, by 11:59 pm
------------------------------------

## Description

-  For lab 10 we are going to be making progress on program 6. All the start code resides within the `src` directory within the program assignment 06 repository.

## TODOs

- `WeightedVertex`
	-  Get this created with all methods implemented
	-  Should be pretty much done from lab 7
- `WeightedEdge`
	-  Get this created with all methods implemented
- `WeightedVertexComparator`
	-  This should be pretty much done from lab 7
-  `WeightedGraph`
	-  Get fields and constructor implemented
	-  Get `addVertex()` and `addWeightedEdge()` working
		-  Including not adding duplicate values
	-  Get `toString()` working
	-  Make dummy versions of `hasPath()`, `getMinimumWeight()`, and `getPath()` that return `false`, `Double.POSITIVE_NaN`, and `new WeightedEdge[0]` respectively.
-  Get `WeightedGraph` working with `testWeightedGraph`
	-  **Note:** Should just be updating line 11

## Running the test code

- At this point you should be able to execute `testWeightedGraph` and see the output of the graph's `toString()` method
- All the sample graphs reside in the `sample_graphs` directory, which resides one level above if you are compiling and running within the `src` directory where all your java files reside.

### sample_weighted_graph_1_with_duplicates

- Here is what I get for `java testWeightedGraph ../sample_graphs/sample_weighted_graph_1_with_duplicates.txt 0 10`, which I run within the `src` directory:

```
hasPathResult = false
minimumWeightResult = NaN
minimumWeightPathResult =
G = (V, E)
V = {1,2,3,4,5,6,7,8,9,10,11,12,13}
E = {(1,2,1.0),(1,3,3.0),(1,4,5.0),(2,3,1.0),(3,4,1.0),(1,5,1.0),
(4,6,2.0),(5,6,1.0),(4,7,6.0),(6,7,5.0),(5,8,4.0),(6,9,2.0),(7,10,2.0),
(8,11,8.0),(9,12,5.0),(9,13,2.0),(9,8,3.0),(10,13,5.0),(12,11,1.0),
(13,12,3.0),(10,9,1.0)}
```

### sample_weighted_graph_2_with_duplicates

-  Here is what I get for `java testWeightedGraph ../sample_graphs/sample_weighted_graph_2_with_duplicates.txt 0 10`, which I run within the `src` directory:

```
hasPathResult = true
minimumWeightResult = 3.0
minimumWeightPathResult = (0,5,1.0),(5,6,0.5),(6,10,1.5)
G = (V, E)
V = {1,0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}
E = {(0,1,1.0),(0,5,1.0),(0,4,1.5),(1,2,1.0),(1,4,1.0),(2,3,1.0),
(3,8,0.5),(4,3,1.0),(4,7,1.0),(4,8,1.5),(5,4,1.0),(5,6,0.5),(6,7,1.0),
(6,10,1.5),(6,11,1.0),(6,18,2.0),(7,8,2.0),(7,10,1.0),(8,9,1.0),
(9,14,0.5),(10,9,1.5),(10,14,1.5),(10,13,0.5),(11,10,1.0),
(11,12,1.0),(12,13,1.0),(12,17,1.0),(12,16,1.5),(13,16,0.5),
(13,14,1.5),(14,15,0.5),(15,19,2.0),(16,19,1.0),(16,15,1.0),
(17,16,1.0),(17,18,1.0),(17,19,1.5),(18,19,1.5),(18,20,0.5),
(19,20,1.5),(20,15,1.0)}
```

## Getting Credit for the Lab

- Once you have everything mentioned above working, demonstrate to a TA/CA.
	-  `java testWeightedGraph ../sample_graphs/sample_weighted_graph_1_with_duplicates.txt 0 10`
	-  `java testWeightedGraph ../sample_graphs/sample_weighted_graph_2_with_duplicates.txt 0 10`
- **Note:** The expected output is shown above.

-  I'm not expecting your code to produce the correct values for `hasPath`, `getMinimumWeight`, and `getPath`
-  If the activity section time is not over, start working on your implementation of Dijkstra's algorithm, continuing on as described in Program Assignment 06's README.

## High level description of PA 6

-  You have three methods related to Dijkstra's algorithm
	-  `hasPath`, `getMinimumWeight`, and `getPath`
-  The implementation of Dijkstra's algorithm will be in a single delegate method, namely:

``` java
private Object getPath(int fromVertex, int toVertex,
WeightedGraphReturnType typeOfInfo)
```

-  The method is to return the appropriate result based on `typeOfInfo`, cast as an `Object`
-  And then the calling method will downcast the return value
	- If the returned Object is named returnValue
	- `hasPath` returns `((Boolean) returnValue).booleanValue()`
	- `getMinimumWeight` returns `((Double) returnValue).doubleValue()`
	- `getPath` returns `((WeightedEdge[]) returnValue)`

## The WeightedGraphReturnType Enumeration

-  `WeightedGraphReturnType` is an `enum` with values
	- `HAS_PATH`
	- `GET_MINIMUM_WEIGHT`
	- `GET_PATH`
- This enumeration disambiguates what value we wish the delegate method to go figure out and have returned.	

## Submission

Submit all your progress so far to github, and submit the latest commit hash to BrightSpace:

```
git add -A
git commit -m "finished lab 10, rest of program assignment 06 will come later."
git push
git rev-parse HEAD
```

For your convenience, [here is a link back to the README for PA 6 to continue working.](/README.md)