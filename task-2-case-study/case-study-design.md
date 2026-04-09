# Task 2 - Case Study Design and Implementation Protocol

## Purpose of this document

This document defines how the implementation should be carried out so that the final conclusions are academically credible. It is written before the final empirical write-up and serves as the protocol that guides the practical work.

## Step 1: Select the repository and issue carefully

The repository should be open source, actively inspectable, and large enough to make context matter, but not so large that the task becomes unmanageable. The selected issue or enhancement should be bounded and should ideally have at least one of the following characteristics: an existing test suite, clear expected behavior, a localized bug or enhancement scope, and a meaningful link to real maintenance work. A change that touches a few related files is preferable to one that requires redesigning a major subsystem.

The issue should not be chosen because it is the easiest possible task. It should be chosen because it exposes at least some of the actual promises and limitations of AI assistance. If the task is purely boilerplate, the resulting analysis will be weak. If the task requires deep architectural restructuring, the signal will be too noisy. The best middle ground is a bounded brownfield task with visible constraints.

## Step 2: Define the baseline human workflow

Before using the AI tool, the team should document what the task appears to require from a normal engineering perspective. This includes identifying the likely affected files, understanding the current behavior, locating tests, and writing down the expected change in one short paragraph. This baseline is important because without it, it becomes impossible to distinguish whether the AI actually helped or whether the task was simply easy.

The team should also note what kind of understanding was necessary before any code was changed. For example, did the task require only reading one file, or did it require tracing behavior across modules? This will later help explain whether the AI succeeded because the task was truly simple or because the repository context was sufficiently manageable.

## Step 3: Use GitHub Copilot during implementation

During implementation, the team should actively record where Copilot was used. For example, note whether it was used to draft a function, propose a test, explain unfamiliar code, or suggest a refactoring. The key point is not to track every keystroke, but to capture the significant moments where the tool materially influenced the solution.

For each such moment, the team should record three things in plain language: what was asked or triggered, what Copilot proposed, and what happened next. Did the suggestion work directly, require editing, or get rejected? This is the raw material for a serious reflection later.

## Step 4: Validate aggressively

Every AI-assisted change must be validated as if it came from an unfamiliar contributor. That means running tests, checking edge cases, reviewing style and naming, and verifying that the change matches the intended behavior rather than only passing superficially. If the repository lacks strong tests, that limitation should itself be discussed in the report because weak validation conditions affect how safely AI suggestions can be used.

This validation step is essential. The literature supports a productivity benefit, but it also shows that plausible answers can be wrong and that integration effort may rise even when individual output improves [2], [12]. Therefore, the final judgment cannot be based on whether the tool produced code quickly. It must be based on whether the team could trust and integrate the result.

## Step 5: Evaluate the outcome using explicit criteria

After implementation, the team should write the evaluation in prose, not as a raw score sheet. The following dimensions should be covered explicitly: how useful Copilot was for understanding the task, how useful it was for producing the implementation, whether the generated tests were meaningful, how much manual correction was required, what mistakes or risks appeared, and whether the process would scale to a more complex repository task.

The final analysis should also identify where effort moved. A common pattern in AI-assisted development is that writing effort decreases while review and verification effort remain high or even increase. If that happened, it should be stated plainly. That is not a failure of the tool. It is part of the actual trade-off.

## Suggested evidence to capture during implementation

The team should save a small but concrete evidence trail. This can include the issue link, the relevant commit or branch, one or two screenshots of AI suggestions, a short note on accepted versus rejected suggestions, a summary of test outcomes, and a brief statement of what the humans changed after the AI proposal. These artifacts are enough to support the presentation and report without turning the repository into a data dump.

## What the final write-up must not do

The final Task 2 write-up must not pretend that literature-derived expectations are empirical results. It is acceptable to say that the literature suggested the tool would help with tests or repetitive code. It is not acceptable to claim that it did so in your case unless you observed it directly. The strongest final report will be the one that combines evidence-backed expectations with honest empirical observations from the actual implementation.
