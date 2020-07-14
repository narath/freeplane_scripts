def nextNodes = c.find{ it.text == "Next!" }
if (nextNodes.size()==0) {
  def child = node.createChild();
  child.text = 'Next!'
  c.select(child)
} else {
  c.select(nextNodes[0])
}

