

def map(function, list):
   fin_list = []
   for item in list:
      a = function(item)
      fin_list.append(a)
   return fin_list
   
def add(x):
   def g(argument):
      solution = argument + x
      return solution
   return g
   
def create_counter(init_value):
   d = {}
   d['value'] = init_value
   def update():
      curr = d['value']
      d['value'] = d['value'] + 1
      return curr
   return update