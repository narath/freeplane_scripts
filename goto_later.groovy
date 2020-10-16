def nextNodes = c.find{ it.text == "Later!" }
if (nextNodes.size()==0) {
  def child = node.createChild();
  child.text = 'Later!'
  c.select(child)
} else {
  c.select(nextNodes[0])
}

