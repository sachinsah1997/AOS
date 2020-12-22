#include<stdio.h>
#include<dirent.h>
#include <sys/stat.h>
#include <unistd.h>
#include <sys/types.h>

int main()
{

DIR*p;
struct dirent *d;

char dirname[10] = "createls";
p=opendir(dirname);
if(p==NULL)
{
perror("Cannot find directory");
exit(-1);
}
while(d=readdir(p)){

 struct stat fileStat;
 stat(d->d_name,&fileStat);
 
        printf(d->d_name);
 
        printf("File Size: \t\t%d bytes\n",fileStat.st_size);
        printf("Number of Links: \t%d\n",fileStat.st_nlink);
        printf("File inode: \t\t%d\n",fileStat.st_ino);
 
        printf("File Permissions: \t");
        printf( (S_ISDIR(fileStat.st_mode)) ? "d" : "-");
        printf( (fileStat.st_mode & S_IRUSR) ? "r" : "-");
        printf( (fileStat.st_mode & S_IWUSR) ? "w" : "-");
        printf( (fileStat.st_mode & S_IXUSR) ? "x" : "-");
        printf( (fileStat.st_mode & S_IRGRP) ? "r" : "-");
        printf( (fileStat.st_mode & S_IWGRP) ? "w" : "-");
        printf( (fileStat.st_mode & S_IXGRP) ? "x" : "-");
        printf( (fileStat.st_mode & S_IROTH) ? "r" : "-");
        printf( (fileStat.st_mode & S_IWOTH) ? "w" : "-");
        printf( (fileStat.st_mode & S_IXOTH) ? "x" : "-");
        printf("\n");
        printf("The file %s a symbolic link\n\n", (S_ISLNK(fileStat.st_mode)) ? "is" : "is not");
    } 

    return 0;
} 
