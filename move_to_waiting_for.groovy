// find the next node so we can select it
def nodeNext = node.getNext()
if (!nodeNext) {
  nodeNext = node.parent
}

// find the Next! node
def moveTo = c.find{ it.text == 'Waiting for' }[0]

// are we cloning this or moving it
// clone it if this is "Goals for this week" or "Projects" are a parent
def pathToRoot = node.getPathToRoot()
def inProjects = pathToRoot.find{ it.text == 'Projects!' }
def inActiveProjects = pathToRoot.find{ it.text == 'Active Projects!' }

def shouldClone = (inProjects || inActiveProjects)

if (shouldClone) {
  moveTo.appendAsCloneWithSubtree(node)
} else {
  node.moveTo(moveTo)
}

// select the next node
c.select(nodeNext);



