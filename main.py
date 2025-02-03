# Importing the dataset

from dataset import func_dataset
dataset=func_dataset()

# Taking the symptoms as input

symptom=input("Enter symptoms (separated by ,): ").split(", ")

# Calculating chances of disease based on input

likely=0
predict=[]
for i in range(len(dataset)):
    diseases=dataset[i][1][0:5]
    for k in symptom:
        if k in diseases:
            likely+=1
    predict.append(likely)
    likely=0

# Selecting and printing the most likely diseases

for a in range(len(symptom),0,-1):
    if a in predict:
        index=-1
        for b in predict:
            index+=1
            if b==a:
                print("You might be having:", dataset[index][0])
        break
