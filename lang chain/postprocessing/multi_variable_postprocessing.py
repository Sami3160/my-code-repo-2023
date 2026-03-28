from langchain_core.runnables import RunnableLambda, RunnableBranch
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from pydantic import BaseModel,Field
from typing import Literal
from langchain_groq import ChatGroq
from dotenv import load_dotenv
import os
load_dotenv()


prompt =ChatPromptTemplate.from_template(
    "Summarize and classify sentiments: {text}"
)

llm=ChatGroq(model="llama-3.1-8b-instant")

parser=StrOutputParser()




#output strcuture
class output(BaseModel):
    summary: str = Field(description="One short sentence summary")
    sentiment: Literal["positive", "negative", "neutral"]



#linking with llm
llm_structure=llm.with_structured_output(output)


def post_process(input:dict)->dict:
    return {
        "summary":input.summary.strip(),
        "sentiment":input.sentiment
    }


def is_positive(x):
    return x["sentiment"] == "positive"

router=RunnableBranch(
    (is_positive, RunnableLambda(lambda x:f"handle positive case \n And the summary is {x['summary']}")),
    RunnableLambda(lambda x: f"Handle negative cases \n And the summary is {x['summary']}")
)


chain= (
    prompt
    | llm.with_structured_output(output)
    | RunnableLambda(post_process)
    | router
)


result = chain.invoke({
    "text": "I love football but hate swimming"
})

print(result)