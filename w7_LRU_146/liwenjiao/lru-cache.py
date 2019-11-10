from collections import OrderedDict


class LRUCache(OrderedDict):

    def __init__(self, capacity):
        self.capacity = capacity

    def get(self, key):
        if key not in self:
            return -1
        self.move_to_end(key)
        return self[key]

    def put(self, key, value):
        if key in self:
            self.move_to_end(key)   #使用 move_to_end (key, last=True) 来改变有序的 OrderedDict 对象的 key-value 顺序，通过这个方法我们可以将排序好的 OrderedDict 对象中的任意一个 key-value 插入到字典的开头或者结尾。
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last=False)    #使用 popitem (last=True) 方法可以让我们按照 LIFO (先进后出) 的顺序删除 dict 中的 key-value，即删除最后一个插入的键值对，如果 last=False 就按照 FIFO (先进先出) 删除 dict 中 key-value。