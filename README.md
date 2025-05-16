[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KOcNqCT3)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=18544679)
# A4 DIY Calculator

Your readme should include the following information. Each student needs to submit all of this information themselves, even when pair programming. 

Group Member Name(s): Ellie Zdancewic

Other collaborators you worked with, including TAs (and feel free to give a shoutout to anyone who was particularly helpful):
TA's: Elaine & Jade Lilian, and Lan, Zhirou & Zihan. 

Any references used besides JavaDoc and course materials:
https://www.baeldung.com/java-instanceof
https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/ 
https://www.calcont.in/Conversion/infix_to_postfix  

Reflection on your experience with this assignment:
I feel like in retrospective these assignments always feel easier than they actually were, but there definitely were some frustrating moments. It was annoying that my tests wouldn't run individually and I could only verify them by building gradle. My general process for completing this assignment was to make a first "draft" of the algorithm by basically translating the words of the instructions into code. Once I had that up and running I did an extensive debugging process, first by fixing all of the errors to allow the code to run, and then using specific examples from the test to correct individual edge cases. It felt very much like whack-a-mole at some point and I ended up having pretty elaborate print statements to try and understand what in the world was going wrong. The most frustrating bug was figuring out that .remove removes the /first/ instance of the given object in a deque, not the one explicitly stated! I feel like deque, while it seems like its a good thing for it to function as both a stack and a queue, is actually worse because you don't know which very similar methods (ex. pop and remove) correspond to which functionality. I feel like it would've been easier to have two different data structures for stack and queues. 



This assignment does lend itself to more visual prototyping, so please feel free to go this route. Are you including slides, pseudocode, comments, or something else?

I am including comprehensive comments. I did take some notes by hand in order to debug, but I mostly used them to replicate the process of moving through the stacks and queues by erasing and rewriting so the final product isn't actually very informative.  