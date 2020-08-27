// find the next node so we can select it
def nodeNext = node.getNext()
if (!nodeNext) {
  nodeNext = node.parent
}

// find the Next! node
def moveTo = c.find{ it.text == 'Next!' }[0]

def pathToRoot = node.getPathToRoot()
def inWeek = pathToRoot.find{ it.text == 'Goals for this week' }
def inProjects = pathToRoot.find{ it.text == 'Projects!' }
def inActiveProjects = pathToRoot.find{ it.text == 'Active Projects!' }

def shouldClone = (inWeek || inProjects || inActiveProjects)

if (shouldClone) {
  moveTo.appendAsCloneWithSubtree(node)
} else {
  node.moveTo(moveTo)
}

// select the next node
c.select(nodeNext);

