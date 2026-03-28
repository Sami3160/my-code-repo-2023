

from langchain_core.runnables import RunnableLambda
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_groq import ChatGroq
from dotenv import load_dotenv
import os
load_dotenv()



#setting pu llm
llm = ChatGroq(
    model="llama-3.1-8b-instant",
    temperature=0.7
)

#prompt
prompt=ChatPromptTemplate.from_template(
    "Summarize in one line : {text}"
)


# post processing function
def clean_summary(text: str) -> str:
    return text.strip()

chain=(
    prompt
    | llm
    | StrOutputParser()
    | RunnableLambda(clean_summary)
)



result=chain.invoke({
    "text": "My name is Sami, I like football and can't swim."
})

print(result)

# #post processing and main logic
# prompt=PromptTemplate.from_template("summarize in one line {text}")


# summarizer_chain=LLMChain(llm=llm, prompt=prompt, output_key="summary")

# def clean_summary(input:dict)->dict:
#     summary=input["summary"].strip().rstrip()
#     return {"clean_summary":summary}

# postprocess_chain=TransformChain(
#     input_variables=["summary"],
#     output_variables=["clean_summary"],
#     transform=clean_summary
# )

# pipeline=SequentialChain(
#     chains=[summarizer_chain, postprocess_chain],
#     input_variables=["text"],
#     output_variables=["clean_summary"],
# )

# print(pipeline.run("My name is sami bhadgaonkar, im just a student in engineering collage, i like to play football, and I dont know how to swim."))