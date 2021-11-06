# Auth @Carlosan

#acquire data:
number = int(input("Write the number : "))
exponent = int(input("Write the exponent  : "))
message = ""
suNumber = 0
coNumber = number

# to process data:
while True: 

    for i in range(0,number):
        suNumber += coNumber
        if (i<number-1):
            message += str(coNumber) + " + "
        else:
            message += str(coNumber) + " = " + str(suNumber) + "\n"        
    
    coNumber = suNumber
    suNumber -= coNumber        
    exponent -= 1

    if (exponent == 1):
        break

# result:
print(message)