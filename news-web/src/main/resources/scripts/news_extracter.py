# //div[@class="news"]/p/a
# //div[@class="list14"]//ul/li/a
import requests
import lxml.html

headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) "
                         "Chrome/67.0.3396.87 Safari/537.36"}


def get_title(url,limt=50):
    tree = get_tree(url)
    title_urls = tree.xpath('//div[@class="list14"]//ul/li/a/@href')
    for ele in title_urls[:limt]:
        yield ele


def get_tree(url):
    print(url)
    res = requests.get(url, headers=headers)
    html = res.text
    return  lxml.html.fromstring(html)
def get_content(url):
    print("抓取url" ,url)
    content_tree = get_tree(url)
    item ={}
    item['title'] = judge_item(content_tree.xpath("//h1/text()"))

    images = content_tree.xpath("//article[@id='mp-editor']//img/@src")
    item['images'] =["java.util.ArrayList" ,images]
    item['content'] ="".join(content_tree.xpath("//article[@id='mp-editor']//p[not(@data-role)]/text()"))
    return  item


def judge_item(cont_list):
    if (len(cont_list) >0) :
        return cont_list[0]
    else:
        return ""

