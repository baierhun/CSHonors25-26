function map(func, x) {
    var returnList = [];
    for(i=0; i<x.length; i++) {
        newValue = func(x[i]);
        returnList.push(newValue)
    }
    return returnList;
}

//function addFive(x) {
//    return x + 5;
//}

var addFive = (x) => x + 5

myList = [1,2,3,4,5];
myNewList = map(addFive, myList);
console.log(myNewList)