package features
import (
	"fmt"
	"os"
	"bufio"
	"strings"
	"strconv"
)
type Student struct{
	Name string
	RollNo string
	Marks int
}


type Class struct{
	Engineers []Student
}


func inputName()string{
	var name string
	fmt.Println("Enter your name")
	fmt.Scanln(&name)
	return name
}

func inputRoll() string {
	fmt.Println("Enter your roll no")
	var roll string
	fmt.Scanln(&roll)
	return roll
  }
  
func inputMarks() int {
	fmt.Println("Enter your marks")
	var marks int
	fmt.Scanln(&marks)
	return marks
}

func (c *Class) NewClass() {

	// fmt.Println(entry)
	var studentsArray []Student
	file, err := os.Open("db.txt")
	if err != nil {
		panic(err)
	}
	scanner := bufio.NewScanner(file)

	for scanner.Scan() {
		line := scanner.Text()
		fields := strings.Split(line, " ")
		marks, _ := strconv.Atoi(fields[2])

		entry := Student{
			Name:   fields[0],
			RollNo: fields[1],
			Marks:  marks,
		}

		studentsArray = append(studentsArray, entry)

	}

	// fmt.Println(studentsArray)
	c.Engineers = studentsArray

}



// crud operations!!!!!........


func (c *Class)AddStudent(){
	name := inputName()
	rollno:=inputRoll()
	marks:=inputMarks()

	entry:=Student{
		RollNo:rollno,
		Name: name,
		Marks: marks}

	c.Engineers =append(c.Engineers , entry)
}


func (c *Class)ShowAll(){
	for _ , val := range c.Engineers{ 		// _ to ignore usless vars
			fmt.Printf("Name: %s Roll No:%s Marks:%d\n ",val.Name, val.RollNo, val.Marks)
	}
}