import itertools
def readInfix(filename):
    with open(filename) as f:
        Infix = f.readlines()
    return Infix[0]
##########################################Student do these 2 function
def priority(op1, op2):
    if op1 <= op2:
        return False
    return True

def peek(stack):
    if stack:
        return stack[-1]

def Infix2Postfix(Infix):
    stack = []
    postfix = ''
    list_Infix = list(Infix)
    for index in list_Infix:
        if (index.isalpha() == True):
            postfix += index
        else:
            if (index == '('):
                stack.append(index)
            elif (index == ')'):
                while stack and peek(stack) != '(' :
                    postfix += stack.pop()
                stack.pop()
            else:
                stack.append(index)
            while (stack and peek(stack) != '(' and priority(peek(stack), index)):
                postfix += stack.pop()
    while(stack):
        postfix += stack.pop()
    return postfix

def logicalNot(a): #phép logic not này xem lại của lab2
    ls = []
    for index in range(0, len(a)):
        ls.append(not a[index])
    return ls

def calculate(a, b, operator):
    list = []
    if operator == "&":
        for index in range(len(a)):
            list.append(a[index] and b[index])
    if operator == "|":
        for index in range(len(a)):
            list.append(a[index] or b[index])
    if operator == ">":
        for index in range(len(a)):
            if a[index]:
                list.append(b[index])
            else:
                list.append(True)
    if operator == "=":
        for index in range(len(a)):
            list.append(a[index] == b[index])
    return list

def Postfix2Truthtable(postfix):
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwyz" 
    var = set()
    s = ""
    stack = []
    for index in postfix:
        if(index in alphabet):
            var.add(index)
            s = s.replace(index, "")
            s += index
    s = ''.join(sorted(s))
    truthTable = list(itertools.product([False, True], repeat= len(var))) 
    table = []
    dict = {}
    tmp = []
    tmp += zip(*truthTable)

    for i in range(len(s)):
        dict[s[i]] = tmp[i]

    num_of_col_in_table = 0
    for key in postfix:
        if (key in alphabet):
            stack.append(key)
        elif(key == "~"):
            l1 = stack.pop()
            dict[num_of_col_in_table] = tuple(logicalNot(dict[l1]))
            stack.append(num_of_col_in_table)
            num_of_col_in_table += 1
        elif(key == "&" or key == ">" or key == "=" or key == "|"):
            key1 = stack.pop()
            key2 = stack.pop()
            dict[num_of_col_in_table] = tuple(calculate(dict[key2], dict[key1], key))
            stack.append(num_of_col_in_table)
            num_of_col_in_table += 1
            
    for index in dict:
        table.append(dict[index])

    table = zip(*table)
    return table
##########################################End student part
def writeTruthtable(table):
    import sys
    outfile=sys.argv[0]
    outfile=outfile[0:-2]
    outfile+="txt"
    with open(outfile, 'w') as f:
        for lines in table:
            for item in lines:
                f.write("%s\t" % item)
            f.write("\n")
    f.close()
def main():
    Infix=readInfix("logicexpression.txt")
    Postfix=Infix2Postfix(Infix)
    Truthtable=Postfix2Truthtable(Postfix)
    writeTruthtable(Truthtable)
main()
