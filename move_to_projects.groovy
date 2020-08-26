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

def moveTo = c.find{ it.text == 'Projects!' }[0]

// if we are already in Projects then we just clone this (we are bring up a sub project
// otherwise we just move it to projects

// are we cloning this or moving it
// clone it if this is "Goals for this week" or "Projects" are a parent
def pathToRoot = node.getPathToRoot()
def inProjects = pathToRoot.find{ it.text == 'Projects!' }

def shouldClone = inProjects

if (shouldClone) {
  moveTo.appendAsCloneWithSubtree(node)
} else {
  node.moveTo(moveTo)
}

// select the next node
c.select(nodeNext);



