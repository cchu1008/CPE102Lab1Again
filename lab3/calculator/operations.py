class Expression(object):
   pass

class BinaryExpression(Expression):
   def __init__(self, lft, rht, st):
      self.lft = lft
      self.rht = rht
      self.st = st
      
   def __str__(self):
      if self.st == "add":
         return '({0} + {1})'.format(self.lft, self.rht)
      
      elif self.st == "minus":
         return '({0} - {1})'.format(self.lft, self.rht)
         
      elif self.st == "multiply":
         return '({0} * {1})'.format(self.lft, self.rht)
         
      elif self.st == "divide":
         return '({0} / {1})'.format(self.lft, self.rht)
      
   def evaluate(self, bindings):
      first = self.lft.evaluate(bindings)
      second = self.rht.evaluate(bindings)
      self._applyOperator(first, second)
      
      
class Assignment(object):
   def __init__(self, id, src):
      self.id = id
      self.src = src


   def __str__(self):
      return 'set {0} = {1}'.format(self.id, self.src)


   def evaluate(self, bindings):
      value = self.src.evaluate(bindings)
      bindings[self.id] = value
      return value


class NegationExpression(Expression):
   def __init__(self, opnd):
      self.opnd = opnd


   def __str__(self):
      return '- {0}'.format(self.opnd)


   def evaluate(self, bindings):
      return -self.opnd.evaluate(bindings)


class IdentifierExpression(Expression):
   def __init__(self, id):
      self.id = id


   def __str__(self):
      return self.id


   def evaluate(self, bindings):
      if self.id in bindings:
         return bindings[self.id]
      else:
         raise UnboundIdentifierException(self.id)


class DoubleConstantExpression(Expression):
   def __init__(self, num):
      self.num = num


   def __str__(self):
      return str(self.num)


   def evaluate(self, bindings):
      return self.num


class AddExpression(BinaryExpression):
   def __init__(self, lft, rht):
      super(AddExpression, self).__init__(lft, rht, "add")
      
   def _applyOperator(self, first, second):
      return (first + second)


class MinusExpression(BinaryExpression):
   def __init__(self, lft, rht):
      super(MinusExpression, self).__init__(lft, rht, "minus")
      
   def _applyOperator(self, first, second):
      return (first - second)


class TimesExpression(BinaryExpression):
   def __init__(self, lft, rht):
      super(TimesExpression, self).__init__(lft, rht, "multiply")      
      
   def _applyOperator(self, first, second):
      return (first * second)


class DivideExpression(BinaryExpression):
   def __init__(self, lft, rht):
      super(DivideExpression, self).__init__(lft, rht, "divide")
      
   def _applyOperator(self, first, second):
      return (first / second)


class UnboundIdentifierException(Exception):
   def __init__(self, value):
      self.value = value
   def __str__(self):
      return 'unbound identifier: {0}'.format(self.value)
