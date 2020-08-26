// https://www.freeplane.org/doc/api/
// ui.informationMessage("Hello world!")
// ui.showInputDialog(node.delegate, "Hello", "World")
// how to use:
// def answer = ui.showInputDialog(node.delegate, "Hello", "World")
// ui.informationMessage("Got answer: " + answer)

// find the next node so we can select it
def nodeNext = node.getNext()
if (!nodeNext) {
  nodeNext = node.parent
}

def moveToProjects = c.find{ it.text == 'Projects!' }[0]
def moveTo = c.find{ it.text == 'Active Projects!' }[0]

// in general we expect active project to come from projects
// if in projects, then clone into Active Projects
// if in active projects, then clone into active Projects (elevating a subtask)
// if not in either of these then move to Projects, and then clone into active projects

def pathToRoot = node.getPathToRoot()
def inProjects = pathToRoot.find{ it.text == 'Projects!' }
def inActiveProjects = pathToRoot.find{ it.text == 'Active Projects!' }

def shouldClone = inProjects || inActiveProjects

if (shouldClone) {
  moveTo.appendAsCloneWithSubtree(node)
} else {
  node.moveTo(moveToProjects)
  moveTo.appendAsCloneWithSubtree(node)
}

// select the next node
c.select(nodeNext);



