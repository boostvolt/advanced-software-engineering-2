# Task 2 - Case Study Overview

## Objective of the case study

Task 2 requires moving from literature into practice. The purpose of the case study is not to prove that AI can fully automate software development. A stronger and more defensible objective is to test whether a selected AI-assisted SWE solution improves a **bounded engineering task** in a realistic open-source setting, and then to analyze the trade-offs, limitations, and gaps that appear in the process. This objective aligns better with the evidence base. Existing research supports gains on bounded tasks, but also shows meaningful limitations once tasks become highly contextual, collaborative, or system-wide [1], [11], [12].

Accordingly, the case study should be framed around a **small but authentic brownfield task** in an open-source repository. The task should require understanding existing code and making a change that can be validated by tests, not simply generating a new standalone script. This matters because the ASE challenge is about large and complex systems, where the difficult part is rarely syntax alone.

## Case study question

A precise case-study question for this project is the following:

**To what extent does a repository-integrated AI coding assistant improve the efficiency and quality of a bounded maintenance or enhancement task in an open-source software project, and what trade-offs emerge in correctness, review effort, context handling, and governance?**

This question is strong for three reasons. First, it avoids overclaiming. Second, it can be evaluated with direct observations. Third, it connects clearly to the literature. It lets the team discuss both the upside of AI assistance and the limits that become visible when the task is embedded in an existing system.

## Why a bounded open-source brownfield task is the right design

A good case study should be realistic but controllable. If the chosen task is too trivial, the exercise will only show that AI can write boilerplate, which is not especially insightful. If the task is too large, the analysis will become noisy and difficult to present. A bounded brownfield task provides the right middle ground. It forces the team to engage with existing structure, tests, naming conventions, and implementation style, while still allowing a clear before-and-after evaluation.

This design is also consistent with the literature. Cisco’s real-world Copilot study suggests that AI tools are especially helpful for repetitive coding, documentation, and tests, but less reliable for large, multi-file, or deeply contextual work [11]. That implies the case study should be difficult enough to expose context issues, but bounded enough that the team can still evaluate the tool credibly.

## Recommended structure of the empirical part

The empirical case study should contain five elements. First, describe the repository and explain why it qualifies as an open, inspectable case. Second, describe the selected issue or change request and why it is representative of a maintenance or enhancement task. Third, apply the selected AI solution during implementation. Fourth, record what the tool contributed and what the humans still had to do manually. Fifth, evaluate the outcome against explicit criteria.

A useful evaluation lens is to ask not only whether the task was completed, but where effort moved. Did the tool reduce writing time but increase checking time? Did it help with test generation but struggle with architecture? Did it accelerate understanding, or did it mainly accelerate drafting? These are better questions than a simplistic measure of whether code was generated at all.

## Evaluation dimensions

The most defensible evaluation dimensions for this project are the following. The first is **implementation usefulness**, meaning whether the tool materially helped create or refine the change. The second is **context sensitivity**, meaning whether the tool respected repository structure, conventions, and behavior. The third is **test usefulness**, meaning whether it helped generate or improve validation. The fourth is **manual correction effort**, meaning how much human intervention was still needed. The fifth is **risk exposure**, meaning whether the tool introduced questionable suggestions, insecure patterns, shallow tests, or misleading explanations. The sixth is **reproducibility**, meaning whether the workflow can be demonstrated clearly in class.

These dimensions are grounded in the literature. Productivity evidence supports checking usefulness [1], [3], [11]. Trust and correctness concerns justify separate attention to validation and risk [2]. Open-source evidence justifies attention to integration effort and coordination, not only local output [12].

## Important boundary for academic honesty

Only the analytical and design portions of Task 2 can be completed before the repository and issue are fixed. The final empirical claims in the case study must come from the team’s own implementation experience. That means the final version of the case study must explicitly document what the AI tool did in your chosen repository, what failed, what needed correction, and what evidence supports the conclusions. The literature can justify expectations, but it cannot substitute for your own observations.
