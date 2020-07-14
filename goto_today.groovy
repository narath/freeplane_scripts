def todayNodes = c.find{ it.text == "Today!" }
if (todayNodes.size()==0) {
  def child = node.createChild();
  child.text = 'Today!'
  c.select(child)
} else {
  c.select(todayNodes[0])
}
