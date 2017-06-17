package ru.tchallenge.service.kernel.domain.task;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ru.tchallenge.service.kernel.conventions.components.MapperService;
import ru.tchallenge.service.kernel.domain.account.AccountRepository;
import ru.tchallenge.service.kernel.domain.task.category.TaskCategoryRepository;
import ru.tchallenge.service.kernel.domain.task.difficulty.TaskDifficultyRepository;
import ru.tchallenge.service.kernel.domain.task.expectation.TaskExpectationRepository;
import ru.tchallenge.service.kernel.domain.task.family.TaskFamilyRepository;
import ru.tchallenge.service.kernel.domain.task.image.TaskImageMapper;
import ru.tchallenge.service.kernel.domain.task.input.TaskInputMapper;
import ru.tchallenge.service.kernel.domain.task.mindflow.TaskMindflowRepository;
import ru.tchallenge.service.kernel.domain.task.option.TaskOptionMapper;
import ru.tchallenge.service.kernel.domain.task.ownership.TaskOwnershipRepository;
import ru.tchallenge.service.kernel.domain.task.snippet.TaskSnippetMapper;
import ru.tchallenge.service.kernel.domain.task.tags.TaskTag;
import ru.tchallenge.service.kernel.domain.task.tags.TaskTagRepository;
import ru.tchallenge.service.kernel.domain.task.workflow.TaskWorkflowRepository;
import ru.tchallenge.service.kernel.generic.GenericMapper;
import ru.tchallenge.service.kernel.generic.entity.EnumeratedEntity;

@MapperService
public class TaskMapperBean extends GenericMapper implements TaskMapper {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TaskCategoryRepository categoryRepository;

    @Autowired
    private TaskDifficultyRepository difficultyRepository;

    @Autowired
    private TaskFamilyRepository familyRepository;

    @Autowired
    private TaskMindflowRepository mindflowRepository;

    @Autowired
    private TaskWorkflowRepository workflowRepository;

    @Autowired
    private TaskExpectationRepository expectationRepository;

    @Autowired
    private TaskTagRepository tagRepository;

    @Autowired
    private TaskOwnershipRepository ownershipRepository;

    @Autowired
    private TaskImageMapper imageMapper;

    @Autowired
    private TaskInputMapper inputMapper;

    @Autowired
    private TaskOptionMapper optionMapper;

    @Autowired
    private TaskSnippetMapper snippetMapper;

    @Override
    public Task asEntity(final TaskInvoice invoice) {
        return asEntityMerged(new Task(), invoice);
    }

    @Override
    public Task asEntityMerged(final Task entity, final TaskInvoice invoice) {
        entity.setIntroduction(invoice.getIntroduction());
        entity.setQuestion(invoice.getQuestion());
        entity.setCategories(transform(invoice.getCategories(), categoryRepository::findById));
        entity.setDifficulty(difficultyRepository.findById(invoice.getDifficulty()));
        entity.setComplexity(invoice.getComplexity());
        if (invoice.getFamilies() != null) {
            entity.setFamilies(transform(invoice.getFamilies(), familyRepository::findById));
        }
        entity.setMindflow(mindflowRepository.findById(invoice.getMindflow()));
        entity.setWorkflow(workflowRepository.findById(invoice.getWorkflow()));
        entity.setExpectation(expectationRepository.findById(invoice.getExpectation()));
        if (invoice.getInput() != null) {
            entity.setInput(inputMapper.asEntity(invoice.getInput()));
        }
        if (invoice.getOptions() != null) {
            entity.setOptions(transform(invoice.getOptions(), optionMapper::asEntity));
        }
        if (invoice.getImages() != null) {
            entity.setImages(transform(invoice.getImages(), imageMapper::asEntity));
        }
        if (invoice.getSnippets() != null) {
            entity.setSnippets(transform(invoice.getSnippets(), snippetMapper::asEntity));
        }
        if (invoice.getTags() != null) {
            entity.setTags(transform(invoice.getTags(), tagRepository::findById));
        }
        entity.setOwnership(ownershipRepository.findById(invoice.getOwnership()));
        if (invoice.getAuthors() != null) {
            entity.setAuthors(transform(invoice.getAuthors(), (a) -> accountRepository.findByLogin(a).getEmployee()));
        }
        return entity;
    }

    @Override
    public TaskInfoComplete asInfoComplete(final Task task) {
        final TaskInfoComplete result = new TaskInfoComplete();
        baseInfo(task, result);
        result.setId(task.getId());
        result.setStatus(task.getStatus().getId());
        result.setCreatedBy(task.getCreatedBy().getAccount().getLogin());
        result.setCategories(transform(task.getCategories(), EnumeratedEntity::getId));
        result.setComplexity(task.getComplexity());
        result.setDifficulty(task.getDifficulty().getId());
        result.setFamilies(transform(task.getFamilies(), EnumeratedEntity::getId));
        result.setMindflow(task.getMindflow().getId());
        result.setWorkflow(task.getWorkflow().getId());
        if (task.getInput() != null) {
            result.setInput(inputMapper.asInfoComplete(task.getInput()));
        }
        result.setOptions(transform(task.getOptions(), optionMapper::asInfoComplete));
        result.setTags(transform(task.getTags(), TaskTag::getId));
        result.setOwnership(task.getOwnership().getId());
        result.setAuthors(transform(task.getAuthors(), (e) -> e.getAccount().getLogin()));
        return result;
    }

    @Override
    public TaskInfoRestricted asInfoRestricted(Task task) {
        final TaskInfoRestricted result = new TaskInfoRestricted();
        baseInfo(task, result);
        result.setOptions(transform(task.getOptions(), optionMapper::asInfoRestricted));
        return result;
    }

    private void baseInfo(final Task entity, final TaskInfo info) {
        info.setIntroduction(entity.getIntroduction());
        info.setQuestion(entity.getQuestion());
        info.setExpectation(entity.getExpectation().getId());
        info.setImages(transform(entity.getImages(), imageMapper::asInfo));
        info.setSnippets(transform(entity.getSnippets(), snippetMapper::asInfo));
    }

    private <T, R> Collection<R> transform(final Collection<T> collection,
                                           final Function<T, R> transformer) {
        return collection.stream().map(transformer).collect(Collectors.toList());
    }
}
