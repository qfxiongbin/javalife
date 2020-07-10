package brian.designparttern.builder;

import org.apache.commons.lang3.StringUtils;

public class ResourcePoolConfig {
    private String name;
    private int maxIdle;
    private int minIdle;
    private int maxTotal;

    private ResourcePoolConfig(Builder builder) {

    }

    public static class Builder{
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFALUT_MIN_IDLE = 0;
        private static final int DEFALUT_TOTAL_IDLE = 8;

        private String name;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFALUT_MIN_IDLE;
        private int totalIdle = DEFALUT_TOTAL_IDLE;

        public ResourcePoolConfig build() {
            if(StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("名称不能为空");
            }

            if(maxIdle > totalIdle){
                throw new IllegalArgumentException("最大空闲数超过总空闲数");
            }

            if(minIdle > maxIdle || minIdle > totalIdle) {
                throw new IllegalArgumentException("最小空闲数超过最大空闲数或总空闲数");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if(StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("名称不能为空");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public Builder setTotalIdle(int totalIdle) {
            this.totalIdle = totalIdle;
            return this;
        }

        public static void main(String[] args) {
            ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                    .setMaxIdle(10)
                    .setMinIdle(0)
                    .setTotalIdle(20)
                    .setName("测试")
                    .build();
        }


    }

}
