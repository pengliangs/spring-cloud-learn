package com.github.pengliangs.common.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.github.pengliangs.common.core.mybatisplus.LambdaDeleteWrapperChain;
import com.github.pengliangs.common.core.mybatisplus.LambdaQueryWrapperChain;
import com.github.pengliangs.common.core.mybatisplus.LambdaUpdateWrapperChain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 * 基础Service 继承于Mybatis-plus
 * </p>
 *
 * @author Caratacus
 */
public interface BaseService<T> {

    /**
     * 批量大小
     */
    int BATCH_SIZE = 1024;

    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param entity 实体对象
     * @return 是否插入成功
     */
    boolean save(T entity);

    /**
     * <p>p
     * 插入（批量）
     * </p>
     *
     * @param entityList 实体对象集合
     */
    void saveBatch(Collection<T> entityList);

    /**
     * <p>
     * 批量修改插入
     * </p>
     *
     * @param entityList 实体对象集合
     * @return 是否操作成功
     */
    boolean saveOrUpdateBatch(Collection<T> entityList);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     * @return 是否操作成功
     */
    boolean removeById(Serializable id);

    /**
     * <p>
     * 删除所有记录
     * </p>
     *
     * @return
     */
    default boolean remove() {
        return remove(Wrappers.emptyWrapper());
    }

    /**
     * <p>
     * 根据 entity 条件，删除记录
     * </p>
     *
     * @param queryWrapper 实体包装类 {@link QueryWrapper}
     * @return
     */
    boolean remove(Wrapper<T> queryWrapper);

    /**
     * <p>
     * 根据 ID 选择修改
     * </p>
     *
     * @param entity 实体对象
     * @return
     */
    boolean updateById(T entity);

    /**
     * <p>
     * 根据 ID 全部修改
     * </p>
     *
     * @param entity 实体对象
     * @return
     */
    boolean updateAllColumnById(T entity);

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param updateWrapper 实体对象封装操作类 {@link UpdateWrapper}
     * @return
     */
    default boolean update(Wrapper<T> updateWrapper) {
        return update(null, updateWrapper);
    }

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity        实体对象
     * @param updateWrapper 实体对象封装操作类 {@link UpdateWrapper}
     * @return
     */
    boolean update(T entity, Wrapper<T> updateWrapper);

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     * @return
     */
    default boolean updateBatchById(Collection<T> entityList) {
        return updateBatchById(entityList, BATCH_SIZE);
    }

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     * @return
     */
    boolean updateBatchById(Collection<T> entityList, int batchSize);

    /**
     * <p>
     * TableId 注解存在更新记录，否插入一条记录
     * </p>
     *
     * @param entity 实体对象
     * @return
     */
    boolean saveOrUpdate(T entity);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     * @return
     */
    T getById(Serializable id);

    /**
     * <p>
     * 根据 Wrapper，查询一条记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @return
     */
    default T getOne(Wrapper<T> queryWrapper) {
        return SqlHelper.getObject(list(queryWrapper));
    }

    /**
     * <p>
     * 根据 Wrapper，查询一条记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @return
     */
    default <R> R getObj(Wrapper<T> queryWrapper, Function<? super Object, R> mapper) {
        return SqlHelper.getObject(listObjs(queryWrapper, mapper));
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @return
     */
    default int count() {
        return count(Wrappers.emptyWrapper());
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @return
     */
    int count(Wrapper<T> queryWrapper);

    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @return
     */
    default List<T> list() {
        return list(Wrappers.emptyWrapper());
    }

    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @return
     */
    List<T> list(Wrapper<T> queryWrapper);

    /**
     * <p>
     * 翻页查询
     * </p>
     *
     * @param page 翻页对象
     * @return
     */
    default IPage<T> page(IPage<T> page) {
        return page(page, Wrappers.emptyWrapper());
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *
     * @return
     */
    default <R> List<R> listObjs(Function<? super Object, R> mapper) {
        return listObjs(Wrappers.emptyWrapper(), mapper);
    }

    /**
     * <p>
     * 翻页查询
     * </p>
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @return
     */
    IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @return
     */

    <R> List<R> listObjs(Wrapper<T> queryWrapper, Function<? super Object, R> mapper);

    /**
     * <p>
     * 翻页查询自定义对象
     * </p>
     *
     * @param page   翻页对象
     * @param mapper
     * @return
     */
    default <R> IPage<R> pageEntities(IPage page, Function<? super T, R> mapper) {
        return pageEntities(page, Wrappers.emptyWrapper(), mapper);
    }

    /**
     * <p>
     * 翻页查询自定义对象
     * </p>
     *
     * @param page    翻页对象
     * @param wrapper {@link Wrapper}
     * @param mapper
     * @return
     */
    <R> IPage<R> pageEntities(IPage page, Wrapper<T> wrapper, Function<? super T, R> mapper);

    /**
     * <p>
     * 根据 Wrapper，查询一条自定义对象记录
     * </p>
     *
     * @param wrapper {@link Wrapper}
     * @param mapper
     * @return
     */
    default <R> R entity(Wrapper<T> wrapper, Function<? super T, R> mapper) {
        return SqlHelper.getObject(entitys(wrapper, mapper));
    }

    /**
     * <p>
     * 查询自定义对象列表
     * </p>
     *
     * @param mapper
     * @return
     */
    default <R> List<R> entitys(Function<? super T, R> mapper) {
        return entitys(Wrappers.emptyWrapper(), mapper);
    }

    /**
     * <p>
     * 查询自定义对象列表
     * </p>
     *
     * @param wrapper {@link Wrapper}
     * @param mapper
     * @return
     */
    <R> List<R> entitys(Wrapper<T> wrapper, Function<? super T, R> mapper);

    /**
     * 查询list,使用list中对象的某个属性做键值,转换成map
     * <p>
     *
     * @param column list中对象的属性,作为键值
     * @return 转换后的map
     */
    default <K> Map<K, T> list2Map(SFunction<T, K> column) {
        return list2Map(Wrappers.<T>emptyWrapper(), column);
    }

    /**
     * 查询list,使用list中对象的某个属性做键值,转换成map
     * <p>
     *
     * @param wrapper 条件
     * @param column  list中对象的属性,作为键值
     * @return 转换后的map
     */
    <K> Map<K, T> list2Map(Wrapper<T> wrapper, SFunction<T, K> column);

    /**
     * 获取查询 LambdaQueryWrapperChain
     * @return
     */
    default LambdaQueryWrapperChain<T> query() {
        return new LambdaQueryWrapperChain<>(this);
    }

    /**
     * 获取修改 LambdaUpdateWrapperChain
     * @return
     */
    default LambdaUpdateWrapperChain<T> update() {
        return new LambdaUpdateWrapperChain<>(this);
    }

    /**
     * 获取删除 LambdaDeleteWrapperChain
     * @return
     */
    default LambdaDeleteWrapperChain<T> delete() {
        return new LambdaDeleteWrapperChain<>(this);
    }

    /**
     * 获取 QueryWrapper
     * @return
     */
    default QueryWrapper<T> queryWrapper() {
        return new QueryWrapper<>();
    }

    /**
     * 获取 UpdateWrapper
     * @return
     */
    default UpdateWrapper<T> updateWrapper() {
        return new UpdateWrapper<>();
    }

}


