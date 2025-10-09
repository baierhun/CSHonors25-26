### Higher Order Functions

def wrapper(func):
    print("Hello")
    func()
    print("Bye")

def print_name():
    print("Jimmy")

wrapper(print_name)

# func is the function applied to each element in our list x
def map(func, x):
    return_list = []
    for i in x:
        new_value = func(i)
        return_list.append(new_value)
    return return_list

def add_five(x):
    return x + 5

my_list = [1,2,3,4,5]
my_new_list = map(add_five, my_list)
print(my_new_list)