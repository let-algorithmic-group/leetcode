/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* sortList(struct ListNode* head){
    if (head == NULL) {
        return head;
    }

    struct ListNode *origin = head;
    struct ListNode *list = head;

    while (list->next) {
        int min = head->val;
        while (head->next) {
            head = head->next;
            if (min > head->val) {
                int tmp = min;
                min = head->val;
                head->val = tmp;
            }
        }
        list->val = min;
        list = list->next;
        head = list;
    }

    return origin;
}
