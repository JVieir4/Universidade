pid_t pid;
int needle = atoi(argv[1]);
int rows = 10;
int cols = 10000;
int rand_max = 10000;
int status;
int **matrix;


//seed random numbers
srand(12345);

//Alocate and populate matrix with random numbers
printf("Generating numbers from 0 to %d... ", rand_max);
matrix = (int **) malloc(sizeof(int*) * rows);
for(int i = 0; i < rows; i++){
    matrix[i] = (int*) malloc(sizeof(int)*cols);
    for(int j = 0; j < cols; j++){
        matrix[i][j] = rand() % rand_max;
    }
}
printf("Done.\n");

for(int i = 0; i < rows; i++){
    if((pid=fork()) == 0){
        printf("[pid %d] row: %d/n", getpid(), i);

        //Start searching for the given number in row #i
        for(int j = 0; j < cols; j++){
            if(matrix[i][j] == needle){
                _exit(i);
            }
        }
        _exit(-1);
    }
}