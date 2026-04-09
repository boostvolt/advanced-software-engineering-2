
# Activity Handout
## Human Judgment Under Pressure: Evaluating AI-Assisted SWE

### Instructions

Read the scenario assigned to your group. Then read **Review A** and **Review B**. Your task is to decide which review you would trust more if you had to approve the change for production. Be ready to explain your answer in one or two sentences.

Do not choose the answer that sounds more confident. Choose the answer that gives you the strongest engineering reason to trust the change.

---

## Scenario 1 – Input Validation

A developer changes a backend endpoint so that it accepts a new optional field from the client. The AI assistant suggests a concise implementation and adds a simple success-case test. The code looks clean and the test passes.

**Review A:**  
“This looks good. The implementation is concise, the naming is clear, and the test passes. I would approve.”

**Review B:**  
“The implementation may be correct for the happy path, but I do not yet see evidence that invalid input, missing fields, and backward compatibility were tested. Before approving, I would want one negative test and confirmation that older clients are unaffected.”

**Question:** Which review is more trustworthy, and why?

---

## Scenario 2 – Refactoring a Utility Function

A helper function is refactored with AI assistance to make the code shorter and easier to read. The generated version uses a different library call but produces the same result in the visible example.

**Review A:**  
“This refactor is cleaner and more modern. Since the output matches the example, the change is safe.”

**Review B:**  
“The refactor may improve readability, but matching one example is not enough. We should confirm whether the new library call behaves the same on edge cases and whether any performance or dependency implications were introduced.”

**Question:** Which review is more trustworthy, and why?

---

## Scenario 3 – Test Generation

An AI assistant generates three unit tests for a function that parses user input. All three tests pass on the first run.

**Review A:**  
“Great improvement. We now have automated coverage, so this is ready to merge.”

**Review B:**  
“The new tests are useful, but passing tests do not automatically mean good coverage. I would first check whether the tests cover malformed input, boundary values, and the failure mode that motivated the change.”

**Question:** Which review is more trustworthy, and why?

---

## Scenario 4 – Security and Privacy

A team member pastes a block of internal code into an external AI chatbot to ask for help understanding it. The answer is helpful and saves time.

**Review A:**  
“This is efficient and practical. The important thing is that the developer got unstuck quickly.”

**Review B:**  
“The time savings may be real, but the workflow itself is risky. Before normalizing this practice, we need to consider whether confidential code was exposed to an external service and whether there is a safer approved workflow.”

**Question:** Which review is more trustworthy, and why?

---

## Final Prompt

After discussing your card, answer this in one sentence:

**What matters more in AI-assisted software engineering: how fast the answer appears, or how well the answer survives review?**

