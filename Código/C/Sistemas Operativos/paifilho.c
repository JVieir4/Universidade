#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>

int main(){

    int i = 10;
     int status;

    pid_t my_pid = getpid();
    printf("my pid = %d\n", my_pid);

    pid_t parent_pid = getppid();
    printf("parent pid = %d\n", parent_pid);

    pid_t res = fork();   //criamos um filho -> res = Fork (),  o pai recebe como res o pid do filho e o filho recebe 0
    printf("fork res = %d\n", res);  //devolve os dois  fork vai ser executado tanto pelo pai como pelo filho
    //tudo de fork para baixo vai devolver sempre os dois

    pid_t res = fork();

    if(res == 0){
        i= i - 5;
        printf("filho | pid = %d\n", getpid());
        printf("filho | parent pid = %d\n", getppid());
        printf("filho | i = %d\n", i);  // i) o filho subtrai 5 ent fica 10-5
        _exit(0);   // o filho terminou ou seja o vou terminar por parte do filho no printf debaixo n é usado
                    // quando queremos dzr q correu mal devlvemos -1 -> _exit(-1);
    } else{
        i = i + 5;
        printf("pai | pid = %d\n", getpid());
        printf("pai | parent pid = %d\n", getppid());
        printf("pai | filho pid = %d\n", res);
        printf("pai | i = %d\n", i);   // i) o pai soma ao 10 5, 10 + 5
        pid_t filho_terminou = wait(&status); //passamos o endereço status, o pai está a dar wait para o filho terminar e dps termina
        printf("pai | depois do wait\n");
        printf("pai: pid filho terminou: %d\n", filho_terminou);
        if(WIFEXITED(status)){
            printf("filho returnvalue: %d\n", WIFEXITED(status));
        } else {
            printf("processo filho falhou\n");
        }
    }

    printf("pid=%d vou terminar\n", getpid());

    return 0;
}