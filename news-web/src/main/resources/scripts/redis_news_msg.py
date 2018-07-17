import redis
import json
import traceback
from news_extracter import *
import time
import random

REDIS_CONN = redis.StrictRedis(host="localhost", password="redis")

NEW_URL = "http://sports.sohu.com/"
NEW_CLASS = "com.m1.news.domain.News"
LIMIT_NUM=50

def save_content(item, idx):
    _item_list = [NEW_CLASS, item]
    js = json.dumps(_item_list, ensure_ascii=False).encode()
    REDIS_CONN.hset("NEWSAPP", idx, js)


def crawler_round():
    #REDIS_CONN.delete("NEWSAPP")
    idx = 1
    try:
        for ur in get_title(NEW_URL,200):
            time.sleep(random.randint(3, 8))
            item = get_content(ur)
            if (len(item['title'].strip()) == 0 or len(item['content'].strip()) == 0):
                continue
            item['id'] =idx


            save_content(item, idx)
            idx += 1
            print(item)
            if (idx >LIMIT_NUM):
                break

    except:
        traceback.print_exc()


if __name__ == '__main__':
    while True:
        crawler_round()
        time.sleep(60 *60 *8)
