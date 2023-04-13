#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>

int main(){
    pid_t pid;
    int status;
    int nproc = 10;

    for(int i = 0; i < nproc; i++){
        if((pid fork()) == 0){
            printf("[proc #%d]  pid: %d", nproc,  getpid());
            _exit(i);
        }
        else{
            wait();
        }
    }





    for(int i = 0; i <= nproc; i++){
        pid_t terminated_pid = wait(&status);
        
    }
}