from flask import Flask,render_template
import requests
import redis

app=Flask(__name__)
cache = redis.Redis(host='redis', port=6379)

@app.route('/')
def index():
    current=requests.get('https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD').json()['USD']
    last=sum([ i['close'] for i in requests.get('https://min-api.cryptocompare.com/data/v2/histominute?fsym=BTC&tsym=USD&limit=9').json()['Data']['Data']])/10
    cache.set('current',current)

    
    return render_template('index.html',current=current,last=last)

if __name__=="__main__":
    app.run(debug=True)