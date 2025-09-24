import os 
import textExtraction
import analysis
def returnImagesList(path="./images"):
    names=[]
    try:
        for entry_name in os.listdir(path):
            full_path=os.path.join(path, entry_name)
            names.append(full_path)
        return names
    except Exception as e:
        print(f"Error reading files {e}")   
        return []
# print(returnImagesList())
wholeText=[]
for image_path in returnImagesList():
    text=textExtraction.extractText(image_path)
    print(image_path)
    # print(text)
    wholeText.append(text)
    # print("\n\n\n\n")
result=analysis.getSentiments(wholeText)


print(result)