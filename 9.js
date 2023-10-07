//{ Driver Code Starts
//Initial Template for javascript


'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

let head = null;

function findNode(head, search_for)
{
    let current = head;
    while (current !== null)
    {
        if (current.data == search_for)
            break;
        current = current.next;
    }
    return current;
}

function printlist(head){
    let current = head; 
    let s='';
    while (current !== null)
    {
        s+=current.data+" ";
        current = current.next;
    }
    console.log(s);
}


function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        head = null;
        head = new Node(input_ar1[0]);
        let tail = head;
        for(let i=1;i<n;i++){
            tail.next = new Node(input_ar1[i]);
            tail = tail.next;
        }
        let obj = new Solution();
        let newHead = obj.pairWiseSwap(head);
        printlist(newHead);
        
    }
}

// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Node} node
 * @return {Node} node
*/


/*
  Pairwise swap a linked list
  The input list will have at least one element
  node is defined as

class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

let head;
This is method only submission.
You only need to complete the below method.
*/

class Solution {
    
    pairWiseSwap(head)
    {
        // If the list has fewer than 2 nodes, there is nothing to do.
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize a previous node and a current node
        let prev = null;
        let curr = head;

        // The new head will be the second node
        head = head.next;

        while (curr !== null && curr.next !== null) {
            // Nodes to be swapped
            let firstNode = curr;
            let secondNode = curr.next;

            // Swap the nodes
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Fix the previous node's next pointer
            if (prev !== null) {
                prev.next = secondNode;
            }

            // Move to the next pair of nodes
            prev = firstNode;
            curr = firstNode.next;
        }

        return head;
    }
}

