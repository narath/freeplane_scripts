// find the next node so we can select it
def nodeNext = node.getNext()
if (!nodeNext) {
  nodeNext = node.parent
}

// find the Next! node
def moveTo = c.find{ it.text == 'Next!' }[0]

node.moveTo(moveTo)

// select the next node
c.select(nodeNext);

