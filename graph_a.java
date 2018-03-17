package algorythms;
import java.util.*;

public class graph_a {
	int size;//количество вершин
	int[][] Array = new int[size][size];//матрица смежности
	boolean visit[] = new boolean[size];//массив посещений вершин
	int numOfEdges = 0;//количесвто дуг
	
	public void DeepSearch(int[][] Arr, int vertex) {//поиск в глубину
		FillGraph(Arr);//заполнение матрицы смежности
		int v = Arr.length;//количество вершин
		for (int i = 0; i<size; i++) {
			visit[i] = false;//заполнение массива посещение - еще  не посетили ни одной вершины
		}
		dfs(0);//вызов функции поиска в глубину
		
	}
	private void dfs(int vertex) {
		visit[vertex] = true;
		System.out.print(vertex+1 +" ");
		int j = 0;
		
		while((j<size-1)&&((Array[j][vertex]==0)||(visit[j]==true))) {
			j++;
			if ((Array[j][vertex]!=0)&&(visit[j]==false)){
				
				dfs(j);
			}	
		
		}		
		
		}
	
	public void WideSearch(int[][] Arr,int vertex) {//поиск в ширину
		FillGraph(Arr);
		System.out.println(Array);
		int v = Arr.length;//количество вершин
		for (int i = 0; i<size; i++) {
			visit[i] = false;
		}
		
		bfs(vertex);
	}
	
	private void bfs(int vertex) {
		Queue queue = new Queue(size);
		visit[vertex] = true;
		queue.insert(vertex);
		System.out.print(vertex+1 +" ");
		
		while (!queue.isEmpty()){
			int curr = queue.pop();
			while((vertex = nearVertex(curr))!=-1){
				visit[vertex] = true;
				queue.insert(vertex);
				System.out.print(vertex+1 + " ");
		}
		
	}
	
		}
	

public int nearVertex(int v) {
	for (int i = 0; i<size; i++) 
		if (Array[v][i]!=0&&visit[i]==false) return i;
		return -1;
}
	public void Dij(int[][] Arr, int vertex) {//алгоритм Дейкстры
		FillGraph(Arr);//заполнение матрицы смежности
	
		int D[] = new int[size];//создние массива искомых путей от известной вершины
		
		for(int i=0; i<size;i++) {//заполнение массива путей максимальными значениями
			D[i] = 1000000;
		}
		
		for (int i = 0; i<size; i++) { //в массив путей вносятся расстояния до смежных вершин
			if ((Array[vertex][i]!=0)&&(visit[i]==false)){
				D[i]=Array[vertex][i];
				visit[i] = false;
			}
		}
		D[vertex] = 0;
		int index=0, k=0;
		
		for (int i = 0; i<size; i++) {
			int min = 1000000;
			for (int j=0;j<size; j++) {//ищем кратчайший путь из известной вершины в смежную с ней вершину
				if ((D[j]<min)&&(visit[j]==false)) {
					min = D[j];
					index=j;
				}
			}
			k=index;
			visit[k] = true;
			for(int j=0;j<size;j++) {//цикл по всем вершинам
				if ((!visit[j])&&(Array[k][j]!=0)&&(D[k]!=1000000)&&(D[k]+Array[k][j]<D[j])){//если вершина не посещена и она смежная с рассматриваемой вершиной
					D[j]=D[k]+Array[k][j];
				}
			}
			
		}
		
		for(int i =0; i<size; i++) {
			System.out.print(D[i] + "  ");//вывод массива путей на экран
		}
	}
		
		

	public void Kruskal(int[][] Arr) {//Алгоритм Краскала
		FillGraph(Arr);
		
		for (int i=0;i<size; i++)
			for (int j=i; j<size;j++) {
				if (Array[i][j]!=0) numOfEdges++;
			}
		
		Edge[] edges = new Edge[numOfEdges];
		int k=0;
		for (int i = 0; i<size; i++) {
			for(int j=i; j<size;j++) {
				if (Array[i][j]!=0) {
					edges[k] = new Edge(Array[i][j], i, j);
					k++;
				}
				
			}
		}
		int D[] = new int[size];
		int result[][] = new int[size][2];
		         sort(edges); // Сортируем ребра
		         int ret = 0; // результат
		         for (int i=0; i<size; i++) {
		        	 D[i] = i;
		         }
		         int l = 0;
		        for (int i=0; i<edges.length; i++) {
		        	if (D[edges[i].v]!=D[edges[i].w]) {
		        		result[l][0] = edges[i].v;
		        		result[l][1] = edges[i].w;
		        		int temp = D[edges[i].v];
		        		l++;
		        		for (int j = 0; j<size;j++) {
		        			if (D[j] == temp) D[j] = D[edges[i].w];
		        		}
		        	}
		        }
		        for (int i = 0; i<size-1; i ++) {//вывод результата на экран
		        	System.out.print("(" + (result[i][0]+1)+ ", " + (result[i][1]+1)+ ") ");
		        	}
		        }
		       
	
		public void sort(Edge[] edge) {//сортировка ребер пузырьком (для Крускала)			
			for (int i = edge.length-1; i>0; i--) {
				for (int j=0; j<i; j++) {
					if(edge[j].compareTo(edge[j+1])==1) {
						Edge temp = edge[j];
						edge[j] = edge[j+1];
						edge[j+1]=temp;
					}
				}
			}
		}

	
	public void PrimasAlg(int[][] Arr, int vertex) {//Алгоритм Прима
		FillGraph(Arr);
		int D[] = new int[size];
		int Parent[] = new int[size];
		for (int i=0; i<size; i++) {
			D[i]=1000000;
			Parent[i]=-1;
			visit[i]=false;
		}
		
		for (int i = 0; i<size; i++) {
			if ((Array[vertex][i]!=0)&&(visit[i]==false)){
				D[i]=Array[vertex][i];
				Parent[i] = vertex;
			}
		}
		
		D[vertex] = 0;
		int index=0, k=0;
		
		for (int i = 0; i<size; i++) {
			int min = 1000000;
			for (int j=0;j<size; j++) {
				if ((D[j]<min)&&(visit[j]==false)) {
					min = D[j];
					index=j;
				}
			}
			k=index;
			visit[k] = true;
			for(int j=0;j<size;j++) {
				if ((!visit[j])&&(Array[k][j]!=0)&&(D[k]!=1000000)&&(Array[k][j]<D[j])){
					D[j]=Array[k][j];
					Parent[j] = k;
				}
			}
			
		}
		
		System.out.print("\n");//вывод результата на экран
		for (int i=0;i<size; i++) {
			System.out.print("(" + (i+1) + ", " + (Parent[i]+1)+ ") ");
		}
		
	}
	
	public void FloydsAlg(int[][] Arr) {//Аргоритм Флойда Уоршелла
		FillGraph(Arr);
		
		int D[][] = new int[size][size];
		for (int i = 0; i<size; i++) {
			for (int j = 0; j<size; j++) {
				if (Array[i][j] == 0 && i!=j) D[i][j]=1000000;
				else D[i][j]=Array[i][j];
			}
		}
		
		for (int i = 0; i<size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k<size; k++) {
					if (D[i][j]<=D[i][k]+D[k][j]) D[i][j] = D[i][j];
					if (D[i][j]>D[i][k]+D[k][j]) D[i][j] = D[i][k]+D[k][j];
					
				}
			}
		}
			for (int i = 0; i<size; i++){
				for (int j = 0; j<size; j++) {//вывод результата работы на экран
					System.out.print(D[i][j] + " ");
					
			}
				System.out.print("\n");
		}
		
	}
	public void FillGraph(int Arr[][]) {//Заполнение матрицы смежности
		size = Arr.length;
		Array = new int [size][size];
		visit = new boolean[size];
		for (int i = 0; i<size; i++) {
			for (int j = 0; j<size; j++ ) {
				Array[i][j] = Arr[i][j];
			}
		}
		
	}
	
	public class Queue {//Очередь. Используется в алгоритме поиска в ширину. 
		private int[] array;//массив для хрнения величин 
		private int size;//размер очереди
		private int count;//текущее количество элементов в очереди
		private int front;//первый элемент в очереди
		private int rear;//последний элемент в очереди
		
	public Queue (int queueSize) {//конструктор,на вход подется размер очереди
		this.size = queueSize;
		this.array = new int[size];
		this.front = 0;
		this.rear = -1;
		this.count = 0;		
	}
	
	public void insert(int value) {//добавление элемента в очередь
		if (rear == size-1) 
			rear=-1;
		array[++rear]= value;
		count++;					
	}
	
	public int pop() {//удалеение первого элемента
		int temp = array[front++];
		if (front == size) front = 0;
		count--;
		return temp;
	}
	public boolean isEmpty() {//проверка пустая ли очередь
		return (count == 0);
	}
}
	public class Edge {//класс ребер. Используется в Алгоритме Краскла
		private int u;//вес
		private int v;//начало ребра  
		private int w;//конец ребра
		
		Edge (int u, int v, int w){//конструктор 
			this.u = u;
			this.v = v;
			this.w = w;
		}		
		public int compareTo(Edge edge) {//метод срвнения. Используется дя сортировки массива ребер
			// TODO Auto-generated method stub
			if (u != edge.u) return u < edge.u ? -1 : 1;
			return 0;
		}		
		}		
	}


