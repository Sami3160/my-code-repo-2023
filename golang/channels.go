package main
import (

	// "fmt"
	// "time"
	// "sync"
)

func sum(){
	// a+b
}
func main(){
	C := make(chan int)

	go func(){
		a:=0
		C<-a
	}()

	output:=  <- c
	
}


func sum(wg *sync.WaitGroup){
	defer wg.Done()
	for i:=1;i<=10;i++{
		fmt.Print(i)
		time.Sleep(100*time.Millisecond)
	}
}

func printChar(wg *sync.WaitGroup){
	defer wg.Done()
	for i:='a';i<='j';i++{
		fmt.Printf("%c",i)
		time.Sleep(100*time.Millisecond)

	}
}