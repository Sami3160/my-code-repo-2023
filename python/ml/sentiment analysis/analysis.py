from transformers import pipeline
sentiment_pipeline = pipeline("sentiment-analysis")
# specific_model = pipeline(model="finiteautomata/bertweet-base-sentiment-analysis")
# specific_model(data)

def getSentiments(data):
    # data = ["I love you", "I hate you"]
    results=sentiment_pipeline(data)
    return results
    
# print(results)