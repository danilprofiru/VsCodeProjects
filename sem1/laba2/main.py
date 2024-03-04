from fastapi import FastAPI
from pydantic import BaseModel
import wikipedia, pyjokes, uvicorn

app = FastAPI()
wikipedia.set_lang('ru')


@app.get('/')
async def joke():
    return pyjokes.get_joke()


@app.get('/{friend}')
def friend_joke(friend: str):
    return friend + ' tells his joke ' + pyjokes.get_joke()


@app.get("/multi/{friend}")
def multi_friends_joke(friend: str, jokes_number: int):
    result = ""
    for i in range(jokes_number):
        result += friend + f" tells his joke #{i + 1}: " + pyjokes.get_joke() + " "
    return result


class Joke(BaseModel):
    friend: str
    joke: str


class JokeInput(BaseModel):
    friend: str


@app.post("/", response_model=Joke)
def create_joke(joke_input: JokeInput):
    """Создание шутки"""
    return Joke(friend=joke_input.friend, joke=pyjokes.get_joke())


class wiki_search(BaseModel):
    object: str
    results: int


@app.get('/search/{object}')
async def search_wiki(object: str, r: int):
    return wikipedia.search(object, results=r)


@app.get('/summary/{object}')
async def wiki_summary(object: str):
    return wikipedia.summary(object)


@app.post('/search_wiki')
async def wikipedia_search(s: wiki_search):
    return wikipedia.search(s.object, results=s.results)


if __name__ == '__main__':
    uvicorn.run(host='0.0.0.0', port=8000, app=app)
